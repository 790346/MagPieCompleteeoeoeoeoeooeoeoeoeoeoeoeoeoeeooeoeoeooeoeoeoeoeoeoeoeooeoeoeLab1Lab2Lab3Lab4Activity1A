/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
        private int findKeyword(String statement, String goal)
    {
    String phrase = statement.trim();
    int psn = phrase.toLowerCase().indexOf(goal.toLowerCase());
    while (psn >= 0)
    {
    String before = " ", after = " ";
    if (psn > 0)
    {
    before = phrase.substring (psn - 1, psn).toLowerCase();
    }
    if (psn + goal.length() < phrase.length())
    {
    after = phrase.substring(psn + goal.length(),
    psn + goal.length() + 1).toLowerCase();
    }
    /* determine the values of psn, before, and after at this point in the method. */
    if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))
    &&
    ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
    {
    return psn;
    }
    psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
    }
    return -1;
    }

    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        String cut = statement.trim();
        if (findKeyword(statement, "no") >= 0)
        {
            response = "Why so negative?";
        }
        else if (findKeyword(statement,"mother") >= 0
                || findKeyword(statement,"father") >= 0
                || findKeyword(statement,"sister") >= 0
                || findKeyword(statement,"brother") >= 0)
        {
            response = "Tell me more about your family.";
        } 
        else if (statement.indexOf("cat") >= 0 
                || findKeyword(statement,"dog") >= 0
                || findKeyword(statement,"cat") >= 0 
                || findKeyword(statement,"pets") >= 0
                || findKeyword(statement,"horse") >= 0
                || findKeyword(statement,"fish") >= 0)
    
       {
            response = "Tell me more about your pets.";
       }
       else if (findKeyword(statement, "sport") >= 0
                || findKeyword(statement, "soccer") >= 0
                || findKeyword(statement, "football") >= 0
                || findKeyword(statement, "baseball") >= 0)
        {
            response = "I don't play any sports. What interests you about sports?";
        }
        
        else if (findKeyword(statement, "rude") >= 0
                || findKeyword(statement, "disrespectful") >= 0
                || findKeyword(statement, "impolite") >= 0
                || findKeyword(statement, "harsh") >= 0)
        {
            response = "Im sorry, was it something i said?...";
        }
        
        else if (findKeyword(statement, "math") >= 0
                || findKeyword(statement, "addition") >= 0
                || findKeyword(statement, "multiplication") >= 0
                || findKeyword(statement, "subtraction") >= 0
                || findKeyword(statement, "division") >= 0)
        {
            response = "I am not designed to answer mathematical questions.";
        }
        
        else if (findKeyword(statement, "I want") >= 0)
        {
            response = "Would you really be happy if you had " + (statement.substring(statement.indexOf("I want") + 7, statement.length() - 1)) + "?";
        }
        
        else if (findKeyword(statement, "you") >= 0)
        
        {
            response = "Why do you " + (statement.substring(statement.indexOf(" ") + 1, statement.indexOf("you") - 1)) + " me?";
        }
       else if(cut.length() == 0)
       
       {
           response = "Say something please.";
       }
       
       else 
       {
            response = getRandomResponse();
       }
       return response;
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4)
        {
            response = "You must be very interested in this.";
        }
        else if (whichResponse == 5)
        {
            response = "Is there anything you'd like to add?";
        }
        return response;
    }
}
