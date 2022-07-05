import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.font.KumoFont;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.nlp.tokenizers.ChineseWordTokenizer;
import com.kennycason.kumo.palette.LinearGradientColorPalette;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.lang.*;


public class test {
    public static void main(String[] args) {
        String path = "C:\\Users\\HUAWEI\\Desktop\\7days\\get_data\\output\\result.txt";
        createWordCountPic(path);
    }

    private static void createWordCountPic(String path){
        FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(200);
        frequencyAnalyzer.setMinWordLength(2);
        frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());
        // 从文件中读取
        List<WordFrequency> wordFrequencies = null;
        try {
            wordFrequencies = frequencyAnalyzer.load(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //将频数前十的词频数扩大5倍
        for(int i = 0; i <= 9; i ++)
        {
            WordFrequency tmp = wordFrequencies.get(i);
            wordFrequencies.remove(i);
            WordFrequency replaceWord = new WordFrequency(tmp.getWord(), tmp.getFrequency() * 10);
            wordFrequencies.add(i, replaceWord);
        }
        java.awt.Font font = new java.awt.Font("STSong-Light", 2, 18);
        //设置图片分辨率
        Dimension dimension = new Dimension(500, 500);
        //此处的设置采用内置常量即可，生成词云对象
        WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
        //设置边界及字体
        wordCloud.setPadding(2);
        //设置圆的半径
        wordCloud.setBackground(new CircleBackground(255));
        wordCloud.setFontScalar(new SqrtFontScalar(12, 42));
        //设置词云显示的三种颜色，越靠前设置表示词频越高的词语的颜色
        wordCloud.setColorPalette(new LinearGradientColorPalette(Color.RED, Color.BLUE, Color.GREEN, 30, 30));
        wordCloud.setKumoFont(new KumoFont(font));
        wordCloud.setBackgroundColor(new Color(255, 255, 255));
        wordCloud.setBackground(new CircleBackground(255));
        wordCloud.build(wordFrequencies);

        //生成词云图路径
        wordCloud.writeToFile("./wordCount.png");
    }
}

