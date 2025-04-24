/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 2 "model.ump"
// line 28 "model.ump"
public class CourseSection
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //CourseSection State Machines
    public enum Status { Planned, Open, Closed, Cancelled }
    private Status status;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public CourseSection()
    {
        setStatus(Status.Planned);
    }

    //------------------------
    // INTERFACE
    //------------------------

    public String getStatusFullName()
    {
        String answer = status.toString();
        return answer;
    }

    public Status getStatus()
    {
        return status;
    }

    public boolean openRegistration()
    {
        boolean wasEventProcessed = false;

        Status aStatus = status;
        switch (aStatus)
        {
            case Planned:
                setStatus(Status.Open);
                wasEventProcessed = true;
                break;
            default:
                // Other states do respond to this event
        }

        return wasEventProcessed;
    }

    public boolean cancel()
    {
        boolean wasEventProcessed = false;

        Status aStatus = status;
        switch (aStatus)
        {
            case Planned:
                setStatus(Status.Cancelled);
                wasEventProcessed = true;
                break;
            case Open:
                setStatus(Status.Cancelled);
                wasEventProcessed = true;
                break;
            case Closed:
                setStatus(Status.Cancelled);
                wasEventProcessed = true;
                break;
            default:
                // Other states do respond to this event
        }

        return wasEventProcessed;
    }

    public boolean requestToRegister()
    {
        boolean wasEventProcessed = false;

        Status aStatus = status;
        switch (aStatus)
        {
            case Open:
                setStatus(Status.Open);
                wasEventProcessed = true;
                break;
            default:
                // Other states do respond to this event
        }

        return wasEventProcessed;
    }

    public boolean classSizeExceedsMaximum()
    {
        boolean wasEventProcessed = false;

        Status aStatus = status;
        switch (aStatus)
        {
            case Open:
                setStatus(Status.Closed);
                wasEventProcessed = true;
                break;
            default:
                // Other states do respond to this event
        }

        return wasEventProcessed;
    }

    public boolean closeRegistration()
    {
        boolean wasEventProcessed = false;

        Status aStatus = status;
        switch (aStatus)
        {
            case Open:
                setStatus(Status.Closed);
                wasEventProcessed = true;
                break;
            default:
                // Other states do respond to this event
        }

        return wasEventProcessed;
    }

    private void setStatus(Status aStatus)
    {
        status = aStatus;
    }

    public void delete()
    {}

}