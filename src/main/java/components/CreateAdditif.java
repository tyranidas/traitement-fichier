package components;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Additif;


public class CreateAdditif {

	
			
		
			
			
			 public static List<Additif> listAdditif() throws IOException
			 {
			// TODO Auto-generated method stub
				List<String> listeAll = RecupFichier.recupData();
				
				List<String> listAdditif = new ArrayList<String>();
				for (String l : listeAll)
				{
					String[] splitList = l.split(";");
					listAdditif.add(splitList[30]);
				}
				List<String> selectAdditif = new ArrayList<String>();
				for (String a : listAdditif)
				{
					if (a.length() > 1)
						{
						selectAdditif.add(a);
						}
						
				}
				List<String> additifUnique = new ArrayList<String>();
				for (String s : selectAdditif)
				{
					String[] splitList = s.split("-");
					for (int i = 0; i < splitList.length; i++)
					{
						String[] splitList2 = splitList[i].split(",");
						for (int j = 0; j < splitList2.length; j++)
						{
							String stripppedString = splitList2[j].strip();
							additifUnique.add(stripppedString);
						}
					}
								
				}
				for (String u : additifUnique)
				{
					System.out.println(u);
				}
				
				Map<String, Additif> mapAdditif = new HashMap<>();
				
				for (String a : additifUnique)
				{
					// si il n'y a pas déja le code du Dep
					if(mapAdditif.get(a) == null);
					{
						// on le créer
						mapAdditif.put(a,new Additif (a));
					}
				}
				List<Additif> additifFinal = new ArrayList<Additif>();
				
				for (Additif a : mapAdditif.values())
				{
					additifFinal.add(a);
					
				}
				
				
				return additifFinal;

		}
}
