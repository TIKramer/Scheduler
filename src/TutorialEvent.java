public class TutorialEvent extends UniEvent implements ISchedule
{
    private int classroom;

    public TutorialEvent()
    {
        super();
        classroom = 22;
    }

    public int getClassroom()
    {
        return classroom;
    }

    public void setClassroom(int inClassroom)
    {
        classroom = inClassroom;
    }

    public String toString()
    {

        return ("This Event is at: " + this.getDateTime().getTime() + "In Classroom: " + classroom + " For Unit: " + this
                .getUnit());
    }

    public void printAlert()
    {
        // TODO Auto-generated method stub

    }
}
