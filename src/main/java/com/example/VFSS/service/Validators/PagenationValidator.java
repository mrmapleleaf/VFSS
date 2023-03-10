package com.example.VFSS.service.Validators;

import com.example.VFSS.exception.InvalidPagenationException;

public class PagenationValidator {
	
	public static void invalidCharacterValidator(String param) {
		if(!param.matches("^[0-9]+$")) {
			throw new InvalidPagenationException("ページの指定は半角数字のみ有効です");
		}
	}
	
	public static void invalidPageValidator(int page, int totalPage) {
		 if(totalPage != 0 && page > totalPage) {
			 throw new InvalidPagenationException("指定されたページが取得したページの総数を超えています");
		}
	}
}
