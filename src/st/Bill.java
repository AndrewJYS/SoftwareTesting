package st;

public class Bill {
	public Bill() {
		
	}
	
	public boolean canTakeOut(int x) {
		//������ҳ����ͷ���true�����ܾͷ���false
		if((x>83)||(x<=0)) {//�ж�x����С�ڵ���0��Ҳ���ܳ��������
			return false;
		}
        if(x>=50) {//��ʼ�ж�1~83Ԫ�����
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
