package net.fragbashers.rgp;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Backend {
	
	public static String getAll() {
		List<String> gtor = new ArrayList<String>();
		Random rand = new Random();
		
		try {
			URL as = new URL("http://www.fragbashers.net/smiteapp/assassin.txt");
			URL gd = new URL("http://www.fragbashers.net/smiteapp/guardian.txt");
			URL hn = new URL("http://www.fragbashers.net/smiteapp/hunter.txt");
			URL mg = new URL("http://www.fragbashers.net/smiteapp/mage.txt");
			URL wr = new URL("http://www.fragbashers.net/smiteapp/warrior.txt");
			Scanner sas = new Scanner(as.openStream());
			Scanner sgd = new Scanner(gd.openStream());
			Scanner shn = new Scanner(hn.openStream());
			Scanner smg = new Scanner(mg.openStream());
			Scanner swr = new Scanner(wr.openStream());

			while (sas.hasNext())
			{
			    String str = sas.nextLine();
			    gtor.add(str);
			}
			while (sgd.hasNext())
			{
			    String str = sgd.nextLine();
			    gtor.add(str);
			}
			while (shn.hasNext())
			{
			    String str = shn.nextLine();
			    gtor.add(str);
			}
			while (smg.hasNext())
			{
			    String str = smg.nextLine();
			    gtor.add(str);
			}
			while (swr.hasNext())
			{
			    String str = swr.nextLine();
			    gtor.add(str);
			}
			//System.out.println(gtor);
			sas.close();
			sgd.close();
			shn.close();
			smg.close();
			swr.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		
		int index = rand.nextInt(gtor.size());
		String rangod = gtor.get(index);
		System.out.println("Random God = " + rangod);
		return rangod;
	}

	public static List<String> getAs() {
		List<String> las = new ArrayList<String>();
		
		try {
			URL as = new URL("http://www.fragbashers.net/smiteapp/assassin.txt");
			Scanner sas = new Scanner(as.openStream());
			while (sas.hasNext())
			{
			    String str = sas.nextLine();
			    las.add(str);
			}
			System.out.println(las);
			sas.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return las;
	}

	public static List<String> getGd() {
		List<String> lgd = new ArrayList<String>();
		
		try {
			URL gd = new URL("http://www.fragbashers.net/smiteapp/guardian.txt");
			Scanner sgd = new Scanner(gd.openStream());
			while (sgd.hasNext())
			{
			    String str = sgd.nextLine();
			   	lgd.add(str);
			}
			System.out.println(lgd);
			sgd.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return lgd;
	}

	public static List<String> getHn() {
		List<String> lhn = new ArrayList<String>();
		
		try {
			URL hn = new URL("http://www.fragbashers.net/smiteapp/hunter.txt");
			Scanner shn = new Scanner(hn.openStream());
			while (shn.hasNext())
			{
			    String str = shn.nextLine();
			    lhn.add(str);
			}
			System.out.println(lhn);
			shn.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return lhn;
	}

	public static List<String> getMg() {
		List<String> lmg = new ArrayList<String>();
		
		try {
			URL mg = new URL("http://www.fragbashers.net/smiteapp/mage.txt");
			Scanner smg = new Scanner(mg.openStream());
			while (smg.hasNext())
			{
			    String str = smg.nextLine();
			    lmg.add(str);
			}
			System.out.println(lmg);
			smg.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return lmg;
	}

	public static List<String> getWr() {
		List<String> lwr = new ArrayList<String>();
		
		try {
			URL wr = new URL("http://www.fragbashers.net/smiteapp/warrior.txt");
			Scanner swr = new Scanner(wr.openStream());
			while (swr.hasNext())
			{
			    String str = swr.nextLine();
			    lwr.add(str);
			}
			System.out.println(lwr);
			swr.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return lwr;
	}
}
