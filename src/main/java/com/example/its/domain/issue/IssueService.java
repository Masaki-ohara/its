// パッケージ名を定義します
package com.example.its.domain.issue;

// LombokのRequiredArgsConstructorアノテーションをインポートします
import lombok.RequiredArgsConstructor;
// SpringのServiceアノテーションをインポートします
import org.springframework.stereotype.Service;
// SpringのTransactionalアノテーションをインポートします
import org.springframework.transaction.annotation.Transactional;

// Listを使用するためのimport文です
import java.util.List;

// サービスクラスを示す@Serviceアノテーションが付与されたクラスです
@Service
// コンストラクタインジェクションを行うためのRequiredArgsConstructorアノテーションです
@RequiredArgsConstructor
public class IssueService {
    // IssueRepositoryのインスタンスを保持するためのフィールドです
    private final IssueRepository issueRepository;

    // すべてのIssueEntityを取得するメソッドです
    public List<IssueEntity> findAll() {
        return issueRepository.findAll();
    }

    // トランザクションを行い、新しいIssueEntityを作成するメソッドです
    @Transactional
    public void create(String summary, String description) {
        // IssueRepositoryを使用してエンティティを挿入します
        issueRepository.insert(summary, description);
        // 後処理が増えたとする
        // 例外をスローすることでトランザクションのロールバックがテストされる可能性があります
//        throw new IllegalStateException("NG");
    }

    // 指定されたIDのIssueEntityを取得するメソッドです
    public IssueEntity findById(long issueId) {
        return issueRepository.findByID(issueId);
    }
}
