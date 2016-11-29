package jp.co.ncsx.example.training;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 正規表現で行う処理を作成する問題の解答例です。
 */
public class RegExpUnitTest {

    /**
     * 「問題2-1：正規表現で文字列内に数値があるか判定する」の解答例
     */
    @Test
    public void findNumeric() {
        String input1 = "1234";
        String input2 = "test1234pp";
        String input3 = "testpp";

        Pattern pattern = Pattern.compile("[0-9]");

        assertTrue(pattern.matcher(input1).find());
        assertTrue(pattern.matcher(input2).find());
        assertFalse(pattern.matcher(input3).find());
    }

    /**
     * 「問題2-2：正規表現で文字列内にアルファベット（大小も判定）があるか判定する」の解答例
     */
    @Test
    public void findAlphabet() {
        String input1 = "1234";
        String input2 = "test1234pp";
        String input3 = "testpp";
        String input4 = "TEST1234pp";
        String input5 = "testPP";

        // アルファベット全種をチェックする場合
        {
            Pattern pattern = Pattern.compile("[a-zA-Z]");

            assertFalse(pattern.matcher(input1).find());
            assertTrue(pattern.matcher(input2).find());
            assertTrue(pattern.matcher(input3).find());
            assertTrue(pattern.matcher(input4).find());
            assertTrue(pattern.matcher(input5).find());
        }

        // 大小文字関係なくアルファベットをチェックする場合
        {
            Pattern pattern = Pattern.compile("(?i)[a-z]");

            assertFalse(pattern.matcher(input1).find());
            assertTrue(pattern.matcher(input2).find());
            assertTrue(pattern.matcher(input3).find());
            assertTrue(pattern.matcher(input4).find());
            assertTrue(pattern.matcher(input5).find());
        }
    }

    /**
     * 「問題2-3：正規表現で文字列内に特定の文字列があるか判定する」の解答例
     * <p>
     * 特定の文字列は「1文字以上のアルファベット小文字＋1文字の数値」とする。
     */
    @Test
    public void findWord1() {
        Pattern pattern = Pattern.compile("[a-z]+[0-9].");

        assertTrue(pattern.matcher("test1234pp").find());
        assertFalse(pattern.matcher("1234pp").find());
        assertTrue(pattern.matcher("t1pp").find());
    }

    /**
     * 「問題2-4：正規表現で文字列内に特定の文字列があるか判定する」の解答例
     * <p>
     * 特定の文字列は「0文字以上のアルファベット小文字＋2文字の数値」とする。
     */
    @Test
    public void findWord2() {
        Pattern pattern = Pattern.compile("[a-z]*[0-9]{2}");

        assertTrue(pattern.matcher("test1234pp").find());
        assertTrue(pattern.matcher("1234pp").find());
        assertFalse(pattern.matcher("1pp").find());
        assertFalse(pattern.matcher("t1pp").find());
    }

}
