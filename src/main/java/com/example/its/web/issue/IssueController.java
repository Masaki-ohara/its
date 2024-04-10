package com.example.its.web.issue;

import com.example.its.domain.issue.IssueEntity;
import com.example.its.domain.issue.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

// コントローラークラスのアノテーション
@Controller
// リクエストマッピングのベースURL
@RequestMapping("/issues")
// コンストラクタインジェクションを使用するためのLombokのアノテーション
@RequiredArgsConstructor
public class IssueController {
    // IssueServiceの依存性注入
    private final IssueService issueService;

    // メソッド: 課題一覧を表示する
    @GetMapping
    // 引数: Modelオブジェクト（ビューにデータを渡すため）
    public String showList(Model model) {
        // issueServiceを使用して全ての課題を取得し、モデルに追加する
        model.addAttribute("issueList", issueService.findAll());
        // issues/list.htmlに遷移する
        return "issues/list";
    }

    // メソッド: 課題作成フォームを表示する
    @GetMapping("/creationForm")
    // 引数: IssueFormオブジェクト（フォームデータをバインドするため）
    public String showCreationForm(@ModelAttribute IssueForm form) {
        // issues/creationForm.htmlに遷移する
        return "issues/creationForm";
    }

    // メソッド: 課題を作成する
    @PostMapping
    // 引数: IssueFormオブジェクト（入力データをバインドするため）、BindingResultオブジェクト（バリデーションエラーを保持するため）、Modelオブジェクト（ビューにデータを渡すため）
    public String create(@Validated @ModelAttribute IssueForm form, BindingResult bindingResult, Model model) {
        // 入力データのバリデーションチェック
        if (bindingResult.hasErrors()) {
            // バリデーションエラーがある場合は、作成フォームを再表示する
            return showCreationForm(form);
        }
        // 入力データが正常な場合は、課題を作成し、課題一覧ページにリダイレクトする
        issueService.create(form.getSummary(), form.getDescription());
        return "redirect:/issues";
    }

    // メソッド: 課題詳細ページを表示する
    @GetMapping("/{issueId}")
    // 引数: issueId（パス変数、表示する課題のID）、Modelオブジェクト（ビューにデータを渡すため）
    public String showDetail(@PathVariable("issueId") long issueId, Model model) {
        // 指定されたIDの課題を取得し、モデルに追加する
        model.addAttribute("issue", issueService.findById(issueId));
        // issues/detail.htmlに遷移する
        return "issues/detail";
    }
}
