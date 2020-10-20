package sakila.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import sakila.service.StatsService;

@WebListener
//접속이 일어나면 구동되는 리스너
public class StatsListener implements HttpSessionListener {
	private StatsService statsService;
    public StatsListener() {}
    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("listener()");
    	//새로 만들어진 세션인지 확인 
    	if(se.getSession().isNew()) {
    		statsService = new StatsService();
    		statsService.countStats();
    	}
    	
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 

    }
	
}
