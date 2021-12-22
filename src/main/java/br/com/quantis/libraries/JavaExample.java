/**
 * Copyright 2021 Quantis All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.quantis.libraries;

import br.com.quantis.libraries.calendar.brazil.BrazilianCalendar;
import br.com.quantis.libraries.calendar.religious.MobileReligiousEvents;

import java.time.LocalDate;

public class JavaExample {

    public static void main(String[] args) {
        new JavaExample().example();
    }

    private void example() {
        getDateOfMobileReligiouseEventFromTheYear();

        System.out.println();

        checkIfTheDateIsHoliday();

        System.out.println();

        checkIfTheDateIsBankingHolidayDay();

        System.out.println();

        checkIfTheDateIsBusinessDay();

        System.out.println();

        checkIfTheDateIsBankingBusinessDay();

        System.out.println();

        countTheNumberOfBusinessDaysInTheDateRange();

        System.out.println("");

        countTheNumberOfBankingBusinessDaysInTheDateRange();

        System.out.println();

        getTheNextBusinessDay();

        System.out.println();

        getTheNextBankingBusinessDay();
    }

    private void getDateOfMobileReligiouseEventFromTheYear() {
        final int year = 2021;
        System.out.println("Carnival: " + MobileReligiousEvents.toCarnivalDate(year));
        System.out.println("Good Friday: " + MobileReligiousEvents.toGoodFridayDate(year));
        System.out.println("Easter: " + MobileReligiousEvents.toEasterDate(year));
        System.out.println("Corpus Christi: " + MobileReligiousEvents.toCorpusChristiDate(year));
    }

    private void checkIfTheDateIsHoliday() {
        final LocalDate date = LocalDate.now();
        if (BrazilianCalendar.isNationalHoliday(date))
            System.out.printf("The '%s' is a holiday%n", date);
        else
            System.out.printf("The '%s' is not a holiday%n", date);
    }

    private void checkIfTheDateIsBankingHolidayDay() {
        final LocalDate date = LocalDate.now();
        if (BrazilianCalendar.isBankingHoliday(date))
            System.out.printf("The '%s' is a banking holiday%n", date);
        else
            System.out.printf("The '%s' is not a banking holiday%n", date);
    }

    private void checkIfTheDateIsBusinessDay() {
        final LocalDate date = LocalDate.now();
        if (BrazilianCalendar.isBusinessDay(date, false))
            System.out.printf("The '%s' is a business day%n", date);
        else
            System.out.printf("The '%s' is not a business day%n", date);
    }

    private void checkIfTheDateIsBankingBusinessDay() {
        final LocalDate date = LocalDate.now();
        if (BrazilianCalendar.isBankingBusinessDay(date))
            System.out.printf("The '%s' is a banking business day%n", date);
        else
            System.out.printf("The '%s' is not a banking business day%n", date);
    }

    private void countTheNumberOfBusinessDaysInTheDateRange() {
        final LocalDate start = LocalDate.of(2019, 3, 12);
        final LocalDate end = LocalDate.of(2021, 11, 15);

        System.out.println("Number of business day: " + BrazilianCalendar.countBusinessDays(start, end, false));
    }

    private void countTheNumberOfBankingBusinessDaysInTheDateRange() {
        final LocalDate start = LocalDate.of(2019, 3, 12);
        final LocalDate end = LocalDate.of(2021, 11, 15);

        System.out.println("Number of banking business day: " + BrazilianCalendar.countBankingBusinessDays(start, end));
    }

    private void getTheNextBusinessDay() {
        final LocalDate date = LocalDate.now();
        System.out.printf("Next business day after %s is %s%n", date, BrazilianCalendar.nextBusinessDay(date, true));
    }

    private void getTheNextBankingBusinessDay() {
        final LocalDate date = LocalDate.now();
        System.out.printf("Next banking business day after %s is %s%n", date, BrazilianCalendar.nextBankingBusinessDay(date));
    }
}
