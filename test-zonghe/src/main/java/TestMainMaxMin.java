import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class TestMainMaxMin {

	
	public static void main(String[] args) {
		
		
		Calendar cale = Calendar.getInstance();  
		cale.set(Calendar.MONTH, 4-1);
        cale.add(Calendar.MONTH, 1);  
        cale.set(Calendar.DAY_OF_MONTH, 0);  
		
        System.out.println("4月最后一天是 ：  " + cale.get(Calendar.DATE));
        int monthMaxDate = cale.get(Calendar.DATE);
		List<PauseMinMax>  list = new ArrayList<>();
		list.add(new PauseMinMax(11, 19));
		list.add(new PauseMinMax(20,22));
		
		getInHospDays(monthMaxDate,1,25,list);
		
		
		
	}
	
	
	public static int[] getInHospDays(int monthMaxDate,int inHospDate,int  outHospDate,List<PauseMinMax>  list){
		
		int max = monthMaxDate;
		int pauseCount = 0;
	
		int[] iday = new int[max];
		for(int i=0;i<max;i++){
			iday[i] = i+1;
		}
		
		int mmm[] = {inHospDate,outHospDate};
		
		for(int i=0;i<max;i++){
			if (i < mmm[0]-1 || iday[i]-1 >= 25) {
				iday[i] = 0;
				pauseCount++;
			}
		}
		
		if(list!=null){
			for(PauseMinMax pau:list){
				for(int i=pau.min-1;i<pau.max-1;i++){
					iday[i] = 0;
					pauseCount++;
				}
			}
		}
		
		int inHospDates [] = new int[monthMaxDate-pauseCount];
		
//		for(int i=0;i<)
		int j = 0;
		for(int i=0;i<iday.length;i++){
			if(iday[i]!=0){
				inHospDates[j++] = iday[i];
			}
		}
		
		System.out.println(Arrays.toString(iday));
		System.out.println(Arrays.toString(inHospDates));
		return inHospDates;
		
		
	}
	
}





