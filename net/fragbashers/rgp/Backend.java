package net.fragbashers.rgp;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class Backend {
	
	public static void DownloadLists(){
		    try {
		    	
		    	URL as = new URL("http://www.fragbashers.net/smite/assassin.txt");
		    	URL gd = new URL("http://www.fragbashers.net/smite/guardian.txt");
		    	URL hn = new URL("http://www.fragbashers.net/smite/hunter.txt");
		    	URL mg = new URL("http://www.fragbashers.net/smite/mage.txt");
		    	URL wr = new URL("http://www.fragbashers.net/smite/warrior.txt");
		    	
		    	FileUtils.copyURLToFile(as, new File("C:/temp/assassin.txt"));
		    	FileUtils.copyURLToFile(gd, new File("C:/temp/guardian.txt"));
		    	FileUtils.copyURLToFile(hn, new File("C:/temp/hunter.txt"));
		    	FileUtils.copyURLToFile(mg, new File("C:/temp/mage.txt"));
		    	FileUtils.copyURLToFile(wr, new File("C:/temp/warrior.txt"));
		
		    } catch (Exception e) {
			
		    }
		
	}
	
	public static String getAll() throws Exception {
		List<String> gtor = new ArrayList<String>();
		Random rand = new Random();
	
		Scanner sas = new Scanner(new File ("C:/temp/assassin.txt"));
		Scanner sgd = new Scanner(new File ("C:/temp/guardian.txt"));
		Scanner shn = new Scanner(new File ("C:/temp/hunter.txt"));
		Scanner smg = new Scanner(new File ("C:/temp/mage.txt"));
		Scanner swr = new Scanner(new File ("C:/temp/warrior.txt"));

		while (sas.hasNext()) {
		    String str = sas.nextLine();
		    gtor.add(str);
		}
		while (sgd.hasNext()) {
		    String str = sgd.nextLine();
		    gtor.add(str);
		}
		while (shn.hasNext()) {
		    String str = shn.nextLine();
		    gtor.add(str);
		}
		while (smg.hasNext()) {
		    String str = smg.nextLine();
		    gtor.add(str);
		}
		while (swr.hasNext()) {
		    String str = swr.nextLine();
		    gtor.add(str);
		}
		sas.close();
		sgd.close();
		shn.close();
		smg.close();
		swr.close();
		
		int index = rand.nextInt(gtor.size());
		String rangod = gtor.get(index);
		//System.out.println("Random God = " + rangod);
		return rangod;
	}

	public static List<String> getAs() {
		List<String> las = new ArrayList<String>();
		
		try {
			Scanner sas = new Scanner(new File ("C:/temp/assassin.txt"));
			while (sas.hasNext()) {
			    String str = sas.nextLine();
			    las.add(str);
			}
			sas.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return las;
	}

	public static List<String> getGd() {
		List<String> lgd = new ArrayList<String>();
		
		try {
			Scanner sgd = new Scanner(new File ("C:/temp/guardian.txt"));
			while (sgd.hasNext()) {
			    String str = sgd.nextLine();
			   	lgd.add(str);
			}
			sgd.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return lgd;
	}

	public static List<String> getHn() {
		List<String> lhn = new ArrayList<String>();
		
		try {
			Scanner shn = new Scanner(new File ("C:/temp/hunter.txt"));
			while (shn.hasNext()) {
			    String str = shn.nextLine();
			    lhn.add(str);
			}
			shn.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return lhn;
	}

	public static List<String> getMg() {
		List<String> lmg = new ArrayList<String>();
		
		try {
			Scanner smg = new Scanner(new File ("C:/temp/mage.txt"));
			while (smg.hasNext()) {
			    String str = smg.nextLine();
			    lmg.add(str);
			}
			smg.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return lmg;
	}

	public static List<String> getWr() {
		List<String> lwr = new ArrayList<String>();
		
		try {
			Scanner swr = new Scanner(new File ("C:/temp/warrior.txt"));
			while (swr.hasNext()) {
			    String str = swr.nextLine();
			    lwr.add(str);
			}
			swr.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return lwr;
	}

	public static String getRole() {
		List<String> rol = new ArrayList<String>();
		rol.add("ADC");
		rol.add("Support");
		rol.add("Mid");
		rol.add("Solo");
		rol.add("Jungle");
		
		Random rand = new Random();
		int rindex = rand.nextInt(rol.size());
		String role = rol.get(rindex);
		
		return role;
	}
}
