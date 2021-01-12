package hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

public class BestAlbum {
	static class Genre {
		private String name;
		private ArrayList<Record> records;
		private int totalPlays;

		public Genre(String name) {
			this.setName(name);
			records = new ArrayList<Record>();
			totalPlays = 0;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public ArrayList<Record> getRecords() {
			return records;
		}

		public int getTotalPlays() {
			return totalPlays;
		}

		public void setTotalPlays(int totalPlays) {
			this.totalPlays = totalPlays;
		}

		public void addRecord(Record r) {
			records.add(r);
			totalPlays += r.getPlays();
		}

		public void sortRecords() {
			Collections.sort(records, Comparator.comparing(Record::getPlays));
		}
	}

	static class Record {
		private String genre;
		private int plays;
		private int id;

		public Record(String genre, int plays, int id) {
			this.setGenre(genre);
			this.setPlays(plays);
			this.setId(id);
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public int getPlays() {
			return plays;
		}

		public void setPlays(int plays) {
			this.plays = plays;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	}

	public static Integer[] solution(String[] genres, int[] plays) {
		Integer[] answer = {};
		HashMap<String, Genre> albumMap = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			String genreName = genres[i];
			Record r = new Record(genres[i], plays[i], i);
			Genre g = albumMap.getOrDefault(genres[i], new Genre(genreName));
			g.addRecord(r);
			albumMap.put(genres[i], g);
		}

		ArrayList<Integer> recordList = new ArrayList<Integer>();
		ArrayList<Genre> genreList = new ArrayList<Genre>();
		for (Entry<String, Genre> e : albumMap.entrySet()) {
			Genre g = e.getValue();
			g.sortRecords();
			genreList.add(g);

		}
		Collections.sort(genreList, Comparator.comparing(Genre::getTotalPlays));
		for (int i = genreList.size() - 1; i >= 0; i--) {
			Genre g = genreList.get(i);
			if (g.getRecords().size() == 1) {
				recordList.add(g.getRecords().get(0).getId());
			} else {
				int size = g.getRecords().size();
				Record r1 = g.getRecords().get(size - 1);
				Record r2 = g.getRecords().get(size - 2);
				if (r1.getPlays() == r2.getPlays()) {
					if(r1.getId() < r2.getId()) {
						recordList.add(r1.getId());
						recordList.add(r2.getId());
					} else {
						recordList.add(r2.getId());
						recordList.add(r1.getId());
					}

				} else {
					recordList.add(r1.getId());
					recordList.add(r2.getId());
				}
			}

		}
		answer = recordList.toArray(new Integer[0]);
		for (Integer i : answer) {
			System.out.println(i);
		}
		return answer;
	}

	public static void main(String[] args) {
		String[] genres = { "classic", "classic", "classic", "classic", "pop" };
		int[] plays = { 500, 800, 800, 800, 2500 };

		solution(genres, plays);

	}
}
