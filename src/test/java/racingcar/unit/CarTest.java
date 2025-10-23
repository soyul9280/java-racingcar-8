package racingcar.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.message.ErrorMessage;

class CarTest {

    @DisplayName("정상: 이름의 길이가 5이하인 경우")
    @Test
    void ValidName_Success() {
        //given
        String name = "Ayo";

        //when
        Boolean result = car.canMakeName(name);

        //then
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("예외: 이름의 길이가 5초과인 경우")
    @Test
    void InvalidName_Long_Fail() {
        String name = "Racing";
        assertThatThrownBy(()->
                car.canMakeName(name)
                        .isIntanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_NAME_LONG));
    }

    @DisplayName("예외: 이름에 빈 문자열, 공백이 들어오는 경우")
    @ParameterizedTest()
    @ValueSource(strings = {""," ","\n","Mike, Ayo"})
    void InvalidName_Blank_Fail(String name) {
        assertThatThrownBy(()->
                car.canMakeName(name)
                        .isIntanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_NAME_BLANK));
    }

    @DisplayName("예외: 이름이 null인 경우")
    @Test
    void InvalidName_Null_Fail() {
        String name = null;
        assertThatThrownBy(()->
                car.canMakeName(name)
                        .isIntanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_NAME_NULL));
    }

    @DisplayName("예외: , 가 아닌 다른 구분자인 경우")
    @Test
    void InvalidName_Not_Comma_Fail() {
        String name = "Ayo/Mike";
        assertThatThrownBy(()->
                car.canMakeName(name)
                        .isIntanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_NAME_SPECIAL_CHARACTERS));
    }

    @DisplayName("예외: 이름에 , 만 적은 경우")
    @Test
    void InvalidName_No_Name_Fail() {
        String name = ",,,";
        assertThatThrownBy(()->
                car.canMakeName(name)
                        .isIntanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_NAME_NO_NAME));
    }

    @DisplayName("예외: 이름에 , 가 연속인 경우")
    @Test
    void InvalidName_Sequence_Comma_Fail() {
        String name = "Mike,,Ayo";
        assertThatThrownBy(()->
                car.canMakeName(name)
                        .isIntanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_NAME_SEQUENCE_COMMA));
    }

    @DisplayName("예외: 이름이 , 로 시작하거나 끝나는 경우")
    @ParameterizedTest(name = "[case: {0}]")
    @ValueSource(strings = {",Ayo,Mike","Mike,Ayo,",",Ayo,"})
    void InvalidName_Location_Comma_Fail(String name) {
        assertThatThrownBy(()->
                car.canMakeName(name)
                        .isIntanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_NAME_LOCATION_COMMA));
    }

}
