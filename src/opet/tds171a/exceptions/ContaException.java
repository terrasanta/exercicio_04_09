package opet.tds171a.exceptions;

public class ContaException extends Exception
{

    /**
     *
     */
    private static final long serialVersionUID = 6666578154656067640L;

    /**
     * 
     */
    public ContaException()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * 
     * @param pMessage
     */
    public ContaException(String pMessage)
    {
        super(pMessage);
        // TODO Auto-generated constructor stub
    }

    /**
     * 
     * @param pCause
     */
    public ContaException(Throwable pCause)
    {
        super(pCause);
        // TODO Auto-generated constructor stub
    }

    /**
     * 
     * @param pMessage
     * @param pCause
     */
    public ContaException(String pMessage, Throwable pCause)
    {
        super(pMessage, pCause);
        // TODO Auto-generated constructor stub
    }

    /**
     * 
     * @param pMessage
     * @param pCause
     * @param pEnableSuppression
     * @param pWritableStackTrace
     */
    public ContaException(String pMessage, Throwable pCause, boolean pEnableSuppression, boolean pWritableStackTrace)
    {
        super(pMessage, pCause, pEnableSuppression, pWritableStackTrace);
        // TODO Auto-generated constructor stub
    }

}
