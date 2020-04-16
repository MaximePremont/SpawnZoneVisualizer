package fr.mpremont.SpawnZoneVisualizer.managers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;

import fr.mpremont.SpawnZoneVisualizer.MainClass;

public class ConfigManager {
	
	public static boolean checkConfig() {
		
		boolean result = true;
		
		String confv = MainClass.getInstance().getConfig().getString("ConfigVersion");
		if(confv == null || confv == "" || (!confv.contains("#"))) {
			
			Bukkit.getConsoleSender().sendMessage("§a[§eSpawnZoneVisualize§a] §cInvalid configuration file !");
			result = false;
			
		}else {
			
			Configuration c = MainClass.getInstance().getConfig();
			String version = c.getString("ConfigVersion").split("#")[0];
			
			if(!version.equalsIgnoreCase("1.0.7")) {
				
				setBasic(c);
				MainClass.getInstance().reloadConfig();
				c = MainClass.getInstance().getConfig();
				
			}
			
			String lang = c.getString("ConfigVersion").split("#")[1];
			String current = c.getString("Language");
			
			if(!lang.equalsIgnoreCase(current)) {
				
				if(current.equalsIgnoreCase("FR")) {
					setFR(c);
				}else if(current.equalsIgnoreCase("OTHER")) {
					setOTHER(c);
				}else {
					setEN(c);
				}
				
				MainClass.getInstance().reloadConfig();
				
			}
			
		}
		
		return result;
		
	}
	
	private static void setFR(Configuration c) {
		
		String radius = c.getString("Radius");
		if(radius == null || radius == "") {
			radius = "20";
		}
		String onMessage = "&aAffichage des zones de spawn activé !===&lASTUCE:&r &aL'utilisation de ce mode est plus simple la nuit.";
		String offMessage = "&cAffichage des zones de spawn désactivé !";
		String noPermission = "&cTu n'as pas la permission !";
		String noConsole = "&cCette commande ne peut pas être utilisée par la console !";
		String newVersion = "&eUne nouvelle version du plugin est disponible !";
		String updateFail = "&cImpossible de vérifier les mises à jour !";
		
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("./plugins/SpawnZoneVisualizer/config.yml"), StandardCharsets.UTF_8);
			writer.write("# ========== Spawn Zone Visualizer by MaximePremont ==========\n"
					+ "\n"
					+ "# Rayon de vérification ( mettre un trop grand rayon est inutile )\n"
					+ "Radius: "+radius+"\n"
					+ "\n"
					+"# Messages ( codes couleurs valides et utiliser === pour un retour à la ligne )\n"
					+"Text:\n"
					+ "    OnMessage: \""+onMessage+"\"\n"
					+ "    OffMessage: \""+offMessage+"\"\n"
					+ "    NoPermission: \""+noPermission+"\"\n"
					+ "    NoConsole: \""+noConsole+"\"\n"
					+ "    NewVersion: \""+newVersion+"\"\n"
					+ "    UpdateFail: \""+updateFail+"\"\n"
					+"# Changer la langue modifiera automatiquement la configuration au prochain redémarrage\n"
					+"# langues disposibles : EN | FR | OTHER\n"
					+ "Language: \"FR\"\n"
					+ "# Vérifier les mises à jours\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [Ne pas toucher] Version de la configuration\n"
					+ "ConfigVersion: 1.0.7#fr");
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void setEN(Configuration c) {
		
		String radius = c.getString("Radius");
		if(radius == null || radius == "") {
			radius = "20";
		}
		String onMessage = "&aDisplay of spawn zones enabled !===&lTIP:&r &aUsing this mode is easier at night.";
		String offMessage = "&cDisplay of spawn zones disabled !";
		String noPermission = "&cYou don't have the permission !";
		String noConsole = "&cThis command cannot be used in the console !";
		String newVersion = "&eA new version of the plugin is available !";
		String updateFail = "&cCould not check for updates !";
		
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("./plugins/SpawnZoneVisualizer/config.yml"), StandardCharsets.UTF_8);
			writer.write("# ========== Spawn Zone Visualizer by MaximePremont ==========\n"
					+ "\n"
					+ "# Check radius ( putting a value higher than the display is useless )\n"
					+ "Radius: "+radius+"\n"
					+ "\n"
					+"# Messages ( color codes are valid and use === for line break)\n"
					+"Text:\n"
					+ "    OnMessage: \""+onMessage+"\"\n"
					+ "    OffMessage: \""+offMessage+"\"\n"
					+ "    NoPermission: \""+noPermission+"\"\n"
					+ "    NoConsole: \""+noConsole+"\"\n"
					+ "    NewVersion: \""+newVersion+"\"\n"
					+ "    UpdateFail: \""+updateFail+"\"\n"
					+"# Changing the language will automatically change the configuration on the next reboot\n"
					+"# Available languages : EN | FR | OTHER\n"
					+ "Language: \"EN\"\n"
					+ "# Check for updates\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [Do not touch] Configuration version\n"
					+ "ConfigVersion: 1.0.7#en");
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void setOTHER(Configuration c) {
		
		String radius = c.getString("Radius");
		if(radius == null || radius == "") {
			radius = "20";
		}
		String onMessage = c.getString("Text.OnMessage");
		if(onMessage == null || onMessage == "") {
			onMessage = "&aDisplay of spawn zones enabled !===&lTIP:&r &aUsing this mode is easier at night.";
		}
		String offMessage = c.getString("Text.OffMessage");
		if(offMessage == null || offMessage == "") {
			offMessage = "&cDisplay of spawn zones disabled !";
		}
		String noPermission = c.getString("Text.NoPermission");
		if(noPermission == null || noPermission == "") {
			noPermission = "&cYou don't have the permission !";
		}
		String noConsole = c.getString("Text.NoConsole");
		if(noConsole == null || noConsole == "") {
			noConsole = "&cThis command cannot be used in the console !";
		}
		String newVersion = c.getString("Text.NewVersion");
		if(newVersion == null || newVersion == "") {
			newVersion = "&eA new version of the plugin is available !";
		}
		String updateFail = c.getString("Text.UpdateFail");
		if(updateFail == null || updateFail == "") {
			updateFail = "&cCould not check for updates !";
		}
		String language = c.getString("Language");
		if(language == null || language == "") {
			language = "EN";
		}
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("./plugins/SpawnZoneVisualizer/config.yml"), StandardCharsets.UTF_8);
			writer.write("# ========== Spawn Zone Visualizer by MaximePremont ==========\n"
					+ "\n"
					+ "# Check radius ( putting a value higher than the display is useless )\n"
					+ "Radius: "+radius+"\n"
					+ "\n"
					+"# Messages ( color codes are valid and use === for line break)\n"
					+"Text:\n"
					+ "    OnMessage: \""+onMessage+"\"\n"
					+ "    OffMessage: \""+offMessage+"\"\n"
					+ "    NoPermission: \""+noPermission+"\"\n"
					+ "    NoConsole: \""+noConsole+"\"\n"
					+ "    NewVersion: \""+newVersion+"\"\n"
					+ "    UpdateFail: \""+updateFail+"\"\n"
					+"# Changing the language will automatically change the configuration on the next reboot\n"
					+"# Available languages : EN | FR | OTHER\n"
					+ "Language: \""+language+"\"\n"
					+ "# Check for updates\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [Do not touch] Configuration version\n"
					+ "ConfigVersion: 1.0.7#other");
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void setBasic(Configuration c) {
		
		String radius = c.getString("Radius");
		if(radius == null || radius == "") {
			radius = "20";
		}
		String onMessage = c.getString("Text.OnMessage");
		if(onMessage == null || onMessage == "") {
			onMessage = "&aDisplay of spawn zones enabled !===&lTIP:&r &aUsing this mode is easier at night.";
		}
		String offMessage = c.getString("Text.OffMessage");
		if(offMessage == null || offMessage == "") {
			offMessage = "&cDisplay of spawn zones disabled !";
		}
		String noPermission = c.getString("Text.NoPermission");
		if(noPermission == null || noPermission == "") {
			noPermission = "&cYou don't have the permission !";
		}
		String noConsole = c.getString("Text.NoConsole");
		if(noConsole == null || noConsole == "") {
			noConsole = "&cThis command cannot be used in the console !";
		}
		String newVersion = c.getString("Text.NewVersion");
		if(newVersion == null || newVersion == "") {
			newVersion = "&eA new version of the plugin is available !";
		}
		String updateFail = c.getString("Text.UpdateFail");
		if(updateFail == null || updateFail == "") {
			updateFail = "&cCould not check for updates !";
		}
		String language = c.getString("Language");
		if(language == null || language == "") {
			language = "EN";
		}
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("./plugins/SpawnZoneVisualizer/config.yml"), StandardCharsets.UTF_8);
			writer.write("# ========== Spawn Zone Visualizer by MaximePremont ==========\n"
					+ "\n"
					+ "# Check radius ( putting a value higher than the display is useless )\n"
					+ "Radius: "+radius+"\n"
					+ "\n"
					+"# Messages ( color codes are valid and use === for line break)\n"
					+"Text:\n"
					+ "    OnMessage: \""+onMessage+"\"\n"
					+ "    OffMessage: \""+offMessage+"\"\n"
					+ "    NoPermission: \""+noPermission+"\"\n"
					+ "    NoConsole: \""+noConsole+"\"\n"
					+ "    NewVersion: \""+newVersion+"\"\n"
					+ "    UpdateFail: \""+updateFail+"\"\n"
					+"# Changing the language will automatically change the configuration on the next reboot\n"
					+"# Available languages : EN | FR | OTHER\n"
					+ "Language: \""+language+"\"\n"
					+ "# Check for updates\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [Do not touch] Configuration version\n"
					+ "ConfigVersion: 1.0.7#CREATION");
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
