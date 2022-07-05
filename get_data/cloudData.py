import matplotlib.pyplot as plt  # 数据可视化
import jieba  # 词语切割
import wordcloud  # 分词
from wordcloud import WordCloud, ImageColorGenerator, STOPWORDS  # 词云，颜色生成器，停止词
from PIL import Image  # 处理图片


def ciyun():

    f = open('./output/result.txt', 'r', encoding='utf-8-sig')
    txt = f.read()
    f.close()
    # print(space_list)
    backgroud = np.array(Image.open('./output/mask.png'))

    wc = WordCloud(width=1400, height=2200,
                   background_color='white',
                   mode='RGB',
                   mask=backgroud,  # 添加蒙版，生成指定形状的词云，并且词云图的颜色可从蒙版里提取
                   max_words=100,
                   font_path='./output/STLITI.TTF',
                   max_font_size=150,
                   relative_scaling=0.8,  # 设置字体大小与词频的关联程度为0.4
                   random_state=50,
                   scale=2
                   ).generate(txt)

    # image_color = ImageColorGenerator(backgroud)  # 设置生成词云的颜色，如去掉这两行则字体为默认颜色
    # wc.recolor(color_func=image_color)

    plt.imshow(wc)  # 显示词云
    plt.axis('off')  # 关闭x,y轴
    plt.show()  # 显示
    wc.to_file('test1_ciyun.jpg')  # 保存词云图


def main():
    ciyun()


if __name__ == '__main__':
    main()