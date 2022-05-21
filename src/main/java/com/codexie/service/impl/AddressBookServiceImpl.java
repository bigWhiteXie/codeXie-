package com.codexie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.codexie.mapper.AddressBookMapper;
import com.codexie.pojo.AddressBook;
import com.codexie.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

}
