package com.example.VFSS.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.VFSS.entity.Subscription;
import com.example.VFSS.entity.User;
import com.example.VFSS.service.SubscriptionService;
import com.example.VFSS.service.Validators.PagenationValidator;

@Controller
@RequestMapping("/mysubscriptions")
public class SubscriptionIndexController {
	
	/** １ページの表示数 */
    private final String limit = "10";

    /** ページネーションで表示するページ数 */
    private int showPageSize = 3;
	@Autowired
	private SubscriptionService subscriptionService;
	
	@Autowired
	private HttpSession session;
	
	public SubscriptionIndexController(SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
	}
	
	@GetMapping("/index")
	@Transactional(readOnly = true)
	public String goToIndex(Model model, @RequestParam HashMap<String, String> params) {
		
		// パラメータを設定し、現在のページを取得する    
        String currentPage = params.get("page");

        // 初期表示ではパラメータを取得できないので、1ページに設定
        if (currentPage == null){
            currentPage = "1";
        }
        // データ取得時の取得件数、取得情報の指定
        HashMap<String, String> search = new HashMap<String, String>();
        search.put("limit", limit);
        search.put("page", currentPage);
        	
        	//「page=」に半角数字以外が使用されているかのチェック
        PagenationValidator.invalidCharacterValidator(currentPage);
        
        User loginUser = (User)session.getAttribute("loginUser");
		//登録サービスの総数取得
		 int total =subscriptionService.allSubscriptionsCount(loginUser.getId());
		 List<Subscription> subscriptionList = subscriptionService.findAllSubscriptions(loginUser.getId(), search);
        
		 // pagination処理
        // "総数/1ページの表示数"から総ページ数を割り出す
        int totalPage = (total + Integer.valueOf(limit) - 1) / Integer.valueOf(limit);    	
        int page = Integer.valueOf(currentPage);
        // 表示する最初のページ番号を算出（今回は3ページ表示する設定）
        // (例)1,2,3ページのstartPageは1。4,5,6ページのstartPageは4
        int startPage = page - (page - 1) % showPageSize;
        // 表示する最後のページ番号を算出
        int endPage = (startPage + showPageSize - 1 > totalPage) ? totalPage : startPage + showPageSize - 1;
        	
     	//「page=」に総ページ数以上の数値が使用されているかのチェック
        PagenationValidator.invalidPageValidator(page, totalPage);
        	
		model.addAttribute("subscriptionList", subscriptionList);
        model.addAttribute("total", total);
        model.addAttribute("page", page);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
		return "index";
	}
}
