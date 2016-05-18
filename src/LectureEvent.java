import java.util.GregorianCalendar;
public class LectureEvent extends UniEvent implements ISchedule
{
private String lectureHall;


public LectureEvent(){
    super();
    lectureHall = "Main hall";
}
public LectureEvent(String inLectureHall, GregorianCalendar date){
    super(date, "OOPD");

    
    
    lectureHall = inLectureHall;
}
public String getLectureHall()
{
    return lectureHall;
}

public void setLectureHall(String inLectureHall)
{
    lectureHall = inLectureHall;
}
public String toString()
{
    return ("This Event is at: " + this.getDateTime().getTime() + "In Classroom: " + lectureHall + " For Unit: " + this
            .getUnit());

}
public void printAlert()
{
    System.out.println("test");
    
}

}

