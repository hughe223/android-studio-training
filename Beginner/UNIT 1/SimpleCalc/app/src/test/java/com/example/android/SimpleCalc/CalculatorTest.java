/*
 * Copyright 2018, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.SimpleCalc;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(JUnit4.class)
@SmallTest
public class CalculatorTest {

    private Calculator mCalculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }

    @Test
    public void powTwoPositiveNumbers() {
        double resultPow = mCalculator.power(2d, 3d);
        assertThat(resultPow, is(equalTo(8d)));
    }

    @Test
    public void powNegativePositive() {
        double resultPow = mCalculator.power(-2d, 3d);
        assertThat(resultPow, is(equalTo(-8d)));
    }

    @Test
    public void powPositiveNegative() {
        double resultPow = mCalculator.power(4d, -2d);
        assertThat(resultPow, is(equalTo((1d/16d))));
    }

    @Test
    public void powZeroPositive() {
        double resultPow = mCalculator.power(0d, 3d);
        assertThat(resultPow, is(equalTo(0d)));
    }

    @Test
    public void powPositiveZero() {
        double resultPow = mCalculator.power(2d, 0);
        assertThat(resultPow, is(equalTo(1d)));
    }

    @Test
    public void powZeroNegativeOne() {
        double resultPow = mCalculator.power(0, -1);
        assertThat(resultPow, is(equalTo(Double.POSITIVE_INFINITY)));
    }

    @Test
    public void powNegativeZeroNegativeTwo() {
        double resultPow = mCalculator.power(-0, -2);
        assertThat(resultPow, is(equalTo(Double.POSITIVE_INFINITY)));
    }




}