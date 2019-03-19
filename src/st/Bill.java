package st;

public class Bill {
	public Bill() {
		
	}
	
	public boolean canTakeOut(int x) {
		//如果能找出，就返回true，不能就返回false
		if((x>83)||(x<=0)) {//判定x不能小于等于0，也不能超过最大金额
			return false;
		}
        if(x>=50) {//开始判定1~83元的情况
			x-=50;
	    }
        if(x>=20) {
	    	x-=20;
	    }
        if(x>=5) {
	    	x-=5;
	    }
        if(x>=5) {
	    	x-=5;
	    }
        if((x>=0)&&(x<=3)) {
	    	return true;
	    }
        return false;
	}
	
}
