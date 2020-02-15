import java.io.*;
import java.util.*;

public class A1 {

	public static void main(String[] args) throws IOException {

		// input csv file and read it in through buffered reader
		// File file = new
		// File("C:\\Users\\meaga\\Documents\\CODE\\CISC3130\\A1Charts.csv");
		FileReader fr = new FileReader("C:\\Users\\meaga\\Documents\\CODE\\CISC3130\\A1Charts.csv");
		BufferedReader reader = new BufferedReader(fr);
		// create linked lists to access list outside of reader
		LinkedList<String> positionList = new LinkedList<String>();
		LinkedList<String> trackList = new LinkedList<String>();
		LinkedList<String> artistList = new LinkedList<String>();
		LinkedList<String> streamList = new LinkedList<String>();
		String row;

		while ((row = reader.readLine()) != null) {
			String[] data = row.split(",");// get contents of line as an array

			String position = data[0];
			positionList.add(position);
			String track = data[1];
			trackList.add(track);
			String artist = data[2];
			artistList.add(artist);
			String streams = data[3];
			streamList.add(streams);
			//String url = data[4];

			// System.out.println(position + " : " + artist + " : " + streams);
		}
		reader.close();

		System.out.println("The artist who had the most streamed is " + artistList.get(1));

		// sort artists in alphabetical order ignoring case
		Collections.sort(artistList, String.CASE_INSENSITIVE_ORDER);
		// remove duplicates in artists
		LinkedList<String> droppedList = new LinkedList<String>();
		int j=1;
		for (int i = 0; i < artistList.size(); i++) {
			if (artistList.indexOf(j) == artistList.size()) {
				break;
			}
			else if((artistList.get(i)) == (artistList.get(j))){
				droppedList.add(artistList.get(i));
				j++;
			}
			
			else if ((artistList.get(i)) == (artistList.get(j))) {
				artistList.remove(j);
			}
		}
		System.out.println(artistList);
		System.out.println(droppedList);
	}

}
