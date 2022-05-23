/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/utj2 for more book information.
***/
package iloveyouboss;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProfileTest {

   @Test
   public void matchAnswersFalseWhenBustMatchCriteriaNotMet() {
      Profile profile = new Profile("Bull Hockey, Inc.");
      Question question = new BooleanQuestion(1, "Got bonuses?");
      Answer proFileAnswer = new Answer(question, Bool.FALSE);
      Criteria criteria = new Criteria();
      profile.add(proFileAnswer);
      Answer criteriaAnswer = new Answer(question, Bool.TRUE);
      Criterion criterion = new Criterion(criteriaAnswer, Weight.MustMatch);
      criteria.add(criterion);

      boolean matches = profile.matches(criteria);

      assertFalse(matches);
   }

   @Test
   public void matchAnswersTrueForAnyDontCarCriteria() {
      Profile profile = new Profile("Bull Hockey, Inc.");
      Question question = new BooleanQuestion(1, "Got milk?");
      Answer proFileAnswer = new Answer(question, Bool.FALSE);
      profile.add(proFileAnswer);
      Criteria criteria = new Criteria();
      Answer criteriaAnswer = new Answer(question, Bool.TRUE);
      Criterion criterion = new Criterion(criteriaAnswer, Weight.DontCare);
      criteria.add(criterion);

      boolean matches = profile.matches(criteria);

      assertTrue(matches);
   }
}
