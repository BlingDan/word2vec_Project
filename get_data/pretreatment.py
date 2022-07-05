"""
包括预处理,中文分词，停顿词处理
预处理：
    仅保留中文内容
"""
import pkuseg
import csv
import os

def process(our_data):
    #去除指定无用的符号

    m1 = map(lambda s: s.replace(' ', ''), our_data)
    return list(m1)

def formate_str(content):
    """保留汉字内容
    input:  a sentence
    output: a sentence that only contains Chinese
    """
    def is_chinese(uchar):
        if u'\u4e00' <= uchar <= u'\u9fa5':
            return True
        else:
            return False

    content_tmp = ''
    for i in content:
        if is_chinese(i):
            content_tmp = content_tmp + i
    return content_tmp

def divide_sentence():
    """分词
    input:  a txt file that only contains chinese
    output:  divide sentence into words
    """
    print("----------------进行中文分词-------------------")
    pkuseg.test('./output/cleaned_data.txt', './output/divide_sentence.txt', model_name="default", user_dict="default",
                postag=False, nthread=10)
    print("------------------分词结束------------------")
    return


def delete_stopwords():
    """去除停用词
    input :  txt file that has divide
    return:  txt file delete stop_word
    """
    file = open("./stopwords/baidu_stopwords.txt", 'r', encoding='utf-8-sig')
    word = file.read().splitlines()
    list = word
    file.close()

    file = open("./output/divide_sentence.txt", "r+", encoding='utf-8-sig')
    file_write = open("./output/result.txt", "w+", encoding='utf-8-sig')
    for line in file.readlines():
        line = line.split()

        line_clean = []
        for word in line:
            if word in list:
                continue
            if len(word) == 1:
                continue
            line_clean.append(word)

        # print("clean:", line_clean)
        # print("line :", line)
        # print("")
        line_clean = " ".join(line_clean)
        print(line_clean)
        file_write.writelines(line_clean + '\n')

    file.close()
    file_write.close()
    return


def remain_chinese_csv():
    """
    input   :none
    return  :'cleaned_data.txt' with only chinese
    """
    csv_reader = csv.reader(open('./output/total_weiboComments_spider0508.csv', 'r', newline='', encoding='utf-8-sig'))
    write_file = open('./output/cleaned_data.txt', 'a+', encoding='utf-8-sig')

    for row in csv_reader:
        txt = row[1]
        txt = formate_str(txt)
        write_file.write(txt + '\n')
    write_file.close()

    return

def remain_chinese_txt(path):
    dirs = os.listdir(path)
    for file in dirs:
        current_path = path + '/'+file
        f = open(current_path, 'r', encoding='utf-8-sig')
        writer = open('./output/cleaned_data.txt', 'a+', encoding='utf-8-sig')

        tmp = ""
        for i in f.readlines():
            idx = i.find('。')

            if idx == -1:
                tmp += i[:-1]  # 若当前行没有。
                continue
            tmp += i[0:idx]
            tmp = formate_str(tmp)
            writer.write(tmp + '\n')
            tmp = "" + i[idx + 1:-1]

        writer.close()
        f.close()
    return

if __name__ == '__main__':
    # remain_chinese_csv()
    # remain_chinese_txt("./output/TXT")
    divide_sentence()
    # #
    delete_stopwords()




