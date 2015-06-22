package net.fragbashers.rgp;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

import org.apache.commons.io.FileUtils;

public class Backend {
	
	static int VersionNumber = 2999999;
	
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
	
	public static void downloadUpdate() throws Exception {
		int ver = Integer.parseInt(getText("http://www.fragbashers.net/smite/version.txt"));
		URL newClient = new URL("http://www.fragbashers.net/smite/RGP_" + ver + ".jar");
		
		JFrame parentFrame = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		File desk = new File(System.getProperty("user.home") + "/Desktop");
		fileChooser.setCurrentDirectory(desk);
		fileChooser.setSelectedFile(new File("RGP_" + ver + ".jar"));
		fileChooser.setDialogTitle("Download new version of RGP");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setFileFilter(new FileFilter() {
			public String getDescription() {
				return "Runnable Jar File (*.jar)";
			}
			public boolean accept(File f) {
				if (f.isDirectory()) {
					return true;
				} else {
					return f.getName().toLowerCase().endsWith(".jar");
				}
			}
		});
		 
		int userSelection = fileChooser.showSaveDialog(parentFrame);
		
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    File fileToSave = fileChooser.getSelectedFile();
		    FileUtils.copyURLToFile(newClient, fileToSave);
		    System.exit(0);
		}
		if (userSelection == JFileChooser.CANCEL_OPTION) {
			Interface frame = new Interface();
			frame.setVisible(true);
		}
	}
	
	public static boolean CheckUpdate() throws Exception {
		int ver = Integer.parseInt(getText("http://www.fragbashers.net/smite/version.txt"));
		System.out.println(ver);
		
		if (ver > VersionNumber) {
			System.out.println("Current version lower than newest!");
			return true;
		} else {
			return false;
		}
	}
	
	public static String getText(String url) throws Exception {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        connection.setUseCaches(false);
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                    connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            response.append(inputLine);

        in.close();

        return response.toString();
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
