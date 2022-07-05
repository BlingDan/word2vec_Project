package coms;

import com.ansj.vec.domain.WordEntry;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Word2VecTest {
    private static final File sportCorpusFile = new File("library/test.txt");

    public static void main(String[] args) throws IOException {
        
        
        //进行分词训练

//        Learn lean = new Learn() ;
//
//        lean.learnFile(sportCorpusFile) ;
//
//        lean.saveModel(new File("library/test.merge.model")) ;
//


        //加载测试

        Word2VEC w2v = new Word2VEC() ;

        w2v.loadJavaModel("library/test.merge.model") ;
        Scanner input=new Scanner(System.in);
        System.out.print("请输入需要进行的操作：\n"+ "1：查询与词语相似度高的所有单词\n"
        		+ "2：查询两个单词\n"+"3：退出");
        int n=input.nextInt();
        while(n!=3)
        {
        	if(n==1)
            {
            	System.out.print("请输入需要查询的词语：");
                String str=input.next();
                System.out.println(w2v.distance(str));
                Set<WordEntry> close_word = w2v.distance(str);

                String[] word = new String[5];
                float[] number = new float[5];
                Iterator<WordEntry> iterator = close_word.iterator();
                for(int i = 0; i <= 4; i ++) {
                    if(!iterator.hasNext()) {
                        break;
                    }
                    WordEntry entity = iterator.next();
                    word[i] = entity.name;
                    number[i] = entity.score;
                }

                for(int i = 0; i <= 4; i ++) {
                    System.out.println(word[i] + ":  " + number[i]);
                }

//               for(float i:w2v.getWordMap().get(str))
//                	System.out.print(i + " ");
            }
            else
            {
            	System.out.print("请输入需要查询的两个词语：");
                String str1=input.next();
                String str2=input.next();
                System.out.println(w2v.distanceWith2Words(str1,str2));
            }
        	 n=input.nextInt();
        }
        System.out.print("已退出！");
        
        
        
    }

    
 
}