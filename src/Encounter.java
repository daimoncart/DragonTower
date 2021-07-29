public class Encounter {
    Dragon winner;
    Dragon loser;
    public void clash(Dragon d1, Dragon d2){
        if (encounter().equals(EncounterType.FRIENDLY))
        {
            d1.setIntelligence(d1.getIntelligence()+getPositive10());
            d2.setIntelligence(d2.getIntelligence()+getPositive10());
            System.out.println("🤍 Friendly encounter: " + d1.getName() + " : " + d2.getName());
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
            System.out.println("⚔ Hostile encounter: " + winner.getName() + " (won) : " + loser.getName() + " (lost)");
        }
    }

    private void increaseStats(){
        winner.setIntelligence(winner.getIntelligence()+getIncrease());
        winner.setFlight(winner.getFlight()+getIncrease());
        winner.setFirebreathing(winner.getFirebreathing()+getIncrease());
    }

    private void decreaseStats(){
        loser.setIntelligence(loser.getIntelligence()+getDecrease());
        loser.setFlight(loser.getFlight()+getDecrease());
        loser.setFirebreathing(loser.getFirebreathing()+getDecrease());
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
