@Remote(SuthenticationRemote.class)
public class AuthenticationBean
{
@Resource
private SessionContext sessionContext;

@Timeout
public void execute(Timer timer)
{
system.out.println("timer timed out");
}

@PostConstruct
public void initialized()
{
system.out.println("@Postconstructed");
}

public void authenticate(String username, String password)
{
TimerService service = sessionContext.getTimerService();
service.createTimer(5000, null);
}

@PreDestroy
public void destroying()
{
System.out.println("preDestroy");
}
}