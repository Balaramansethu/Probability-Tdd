package com.probability;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

public class probabiltyTest
{


    private static Probability certainEventProbability;
    private static Probability probabilityOfHeads;
    private static Probability halfProbability;

    @BeforeAll
    static void beforeAll(){
        certainEventProbability = new Probability(1);
        probabilityOfHeads = new Probability(0.5);
        halfProbability = new Probability(0.5);
    }

    @Test
    public void toCheckEqualityWhenTheProbabilityOfGettingAHeadIsComparedWithProbabilityOfGettingATail(){
        Probability probabilityOfTails = new Probability(0.5);

        assertThat(probabilityOfHeads, is(equalTo(probabilityOfTails)));
    }

    @Test
    public void toCheckInEqualityWhenTheProbabilityOfGettingAHeadIsComparedWithProbabilityOfGettingOneInDive(){
        Probability probabilityOfOneInDice = new Probability(0.167);

        assertThat(probabilityOfHeads, is(not(equalTo(probabilityOfOneInDice))));
    }

    @Test
    public void toCheckWhetherTheProbabilityOfTwoCertainEventsHappeningTogetherIsAlsoCertainEvent(){
        assertThat(certainEventProbability.and(certainEventProbability), is(equalTo(certainEventProbability)));
    }

    @Test
    public void toCheckWhetherTheProbabilityOfQuarterProbabilityEventHappeningTogetherWithPointOneTwoFiveProbabilityEvent(){
        Probability quaterProbability = new Probability(0.25);
        Probability pointOneTwoFiveProbability = new Probability(0.125);
        assertThat(halfProbability.and(quaterProbability), is(equalTo(pointOneTwoFiveProbability)));
    }

    @Test
    public void toCheckWhetherTheProbabilityOfACertainEventNotOccurringIsEqualToTheProbabilityOfAnImpossibleEvent(){
        Probability impossibleEventProbability = new Probability(0);
        assertThat(certainEventProbability.not(), is(equalTo(impossibleEventProbability)));
    }

    @Test
    public void toCheckWhetherTheProbabilityOfHeadInACoinTossNotOccurringIsEqualToHalfProbability(){
        assertThat(probabilityOfHeads.not(), is(equalTo(halfProbability)));
    }
}
