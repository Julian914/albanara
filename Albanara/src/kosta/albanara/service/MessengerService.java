package kosta.albanara.service;

import kosta.albanara.dao.MessengerDao;

public class MessengerService {
	public static MessengerService instance;
	public static MessengerDao messengerDao;

	public static MessengerService getInstance() {
		if (instance == null) {
			messengerDao = MessengerDao.getInstance();
			return new MessengerService();
		}
		return instance;
	}
}
