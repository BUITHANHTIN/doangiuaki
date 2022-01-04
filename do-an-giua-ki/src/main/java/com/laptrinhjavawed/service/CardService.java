package com.laptrinhjavawed.service;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavawed.DAO.IAccount;
import com.laptrinhjavawed.DAO.ICard;
import com.laptrinhjavawed.imp.service.IAccountService;
import com.laptrinhjavawed.imp.service.ICardService;
import com.laptrinhjavawed.model.Account;
import com.laptrinhjavawed.model.Card;

public class CardService implements ICardService {
	@Inject
	private ICard card;

	@Override
	public boolean InsertCard(Card cardd) {
		if (card.InsertCard(cardd)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Card> getAllbyAccountId(int id) {
		return card.getAllbyAccountId(id);
	}

	@Override
	public boolean UpdateCardByIdProduct(int count, int idAccount, int idProduct) {
		if (card.UpdateCardByIdProduct(count, idAccount, idProduct)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean DeleteCardByIdProduct(int idAccount, int idProduct) {
		if (card.DeleteCardByIdProduct(idAccount, idProduct)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void DeleteCard(int idAccount) {
		card.DeleteCard(idAccount);

	}

}
