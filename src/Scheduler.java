
public class Scheduler
{
private UniEvent[] listOfEvents;


public Scheduler(){
    setListOfEvents(new UniEvent[10]);
}


public UniEvent[] getListOfEvents()
{
    return listOfEvents;
}


public void setListOfEvents(UniEvent[] inListOfEvents)
{
    listOfEvents = inListOfEvents;
}
}
