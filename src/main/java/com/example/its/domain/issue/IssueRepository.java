// パッケージ名を定義します
package com.example.its.domain.issue;

// MyBatisのMapperインターフェースであることを示すアノテーションです
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

// Listを使うためのimport文です
import java.util.List;

// Mapperインターフェースの定義です
@Mapper
public interface IssueRepository {

    // issuesテーブルからすべてのエンティティを取得するためのメソッドです
    @Select("select * from issues")
    List<IssueEntity> findAll();

    // issuesテーブルに新しいエントリを挿入するためのメソッドです
    @Insert("insert into issues (summary, description) values (#{summary}, #{description})")
    void insert(String summary, String description);

    // 指定したIDのissueを検索するためのメソッドです
    @Select("select * from issues where id = #{issueId}")
    IssueEntity findByID(long issueId);
}
