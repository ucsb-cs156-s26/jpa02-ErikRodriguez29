package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void object_equals_itself_equals_returns_true(){
        assertEquals(team.equals(team), true);
    }

    @Test
    public void objects_not_same_equals_returns_false()
    {
        assertEquals(team.equals("Hello"), false);
    }

    @Test
    public void objects_with_same_team_name_diff_members_returns_false(){
        Team non_equivalent_team = new Team("test-team");
        non_equivalent_team.addMember("Erik");
        assertEquals(team.equals(non_equivalent_team), false);
    }

    @Test
    public void objects_with_diff_team_name_same_members_returns_false(){
        Team non_equivalent_team = new Team("test-team2");
        team.addMember("Erik");
        non_equivalent_team.addMember("Erik");
        assertEquals(team.equals(non_equivalent_team), false);
    }

    @Test
    public void objects_with_no_team_members_same_team_name_equals_returns_true()
    {
        Team equivalent_team = new Team("test-team");
        assertEquals(team.equals(equivalent_team), true);
        assertEquals(equivalent_team.equals(team), true);
    }

    @Test
    public void objects_with_same_properties_equals_returns_true(){
        Team equivalent_team = new Team("test-team");
        team.addMember("Erik");
        equivalent_team.addMember("Erik");
        assertEquals(team.equals(equivalent_team), true);
        assertEquals(equivalent_team.equals(team), true);
    }

    @Test
    public void hash_function_test() {
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }
}
