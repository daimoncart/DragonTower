

public class Encounter {
    Dragon winner;
    Dragon loser;
    public void clash(Dragon d1, Dragon d2){
        if (encounter().equals(EncounterType.FRIENDLY))
        {
            d1.setIntelligence(d1.getIntelligence()+getPositive10());
            d2.setIntelligence(d2.getIntelligence()+getPositive10());
            System.out.println("In the course of a friendly encounter");
            System.out.println(d1.getName() + " has increased its intelligence to " + d1.getIntelligence() + ".");
            System.out.println("and " + d2.getName() + " has increased its intelligence to " + d2.getIntelligence() + ".");
        } else
        {
            if (d1.max()*d1.average()*Math.random() > d2.max()*d2.average()*Math.random())
            {
                winner = d1;
                loser = d2;
            }
            else
            {
                winner = d2;
                loser = d1;
            }
            increaseStats();
            decreaseStats();
        }
    }

    private void increaseStats(){
        double avgBefore = (int) winner.average();
        winner.setIntelligence(winner.getIntelligence()+getIncrease());
        winner.setFlight(winner.getFlight()+getIncrease());
        winner.setFirebreathing(winner.getFirebreathing()+getIncrease());
        System.out.println("In the course of a hostile encounter");
        System.out.println(winner.getName() + " has won. Its average stats are now " + (int) winner.average() + ".");
        System.out.println("Its previous average stats were " + (int) avgBefore + ".");
    }

    private void decreaseStats(){
        double avgBefore = (int) loser.average();
        loser.setIntelligence(loser.getIntelligence()+getDecrease());
        loser.setFlight(loser.getFlight()+getDecrease());
        loser.setFirebreathing(loser.getFirebreathing()+getDecrease());
        System.out.println(loser.getName() + " has lost. Its average stats are now " + (int) loser.average() + ".");
        System.out.println("Its previous average stats were " + (int) avgBefore + ".");
    }

    private static int getIncrease()
    {
        return (int) (Math.random()*10-2);
    }

    private static int getDecrease()
    {
        return (int) (Math.random()*10-8);
    }


    private static int getPositive10()
    {
        return (int) (Math.random()*10+1);
    }

    private static EncounterType encounter()
    {
        return Math.random()>0.7 ? EncounterType.FRIENDLY : EncounterType.HOSTILE;
    }

    private enum EncounterType
    {
        FRIENDLY, HOSTILE
    }
}
