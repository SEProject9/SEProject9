package mapper;

import java.util.List;

import pojo.Diary;

public interface DiaryMapper {
	public void add(Diary dia);

	public Diary get(int id);

	public int update(String dia_text);

	public List<Diary> search(Diary dia);

}
