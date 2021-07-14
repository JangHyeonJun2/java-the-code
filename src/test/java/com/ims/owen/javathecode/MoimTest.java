package com.ims.owen.javathecode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoimTest {
    @Test
    void moimTest() {
        Moim moim = new Moim();
        moim.maxNumberOfAttendees = 100;
        moim.numberOfEnrollment = 10;
        Assertions.assertThat(false).isEqualTo(moim.isEnrollmentFull());
    }

}