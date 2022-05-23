package iloveyouboss;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ScoreCollectionTest {

    @Test
    public void test() {
        // 준비:given
        ScoreCollection collection = new ScoreCollection();
        collection.add(() -> 5);
        collection.add(() -> 7);

        // 실행:when
        int actualResult = collection.arithmeticMean();

        // 단언:then
        assertThat(actualResult, equalTo(6));

    }
}