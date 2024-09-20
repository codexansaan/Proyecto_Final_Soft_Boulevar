package com.boulevar.Soft.Boulevar.Commons;

import com.boulevar.Soft.Boulevar.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericServiceImpl<T,ID extends Serializable> implements GenericServiceAPI<T, ID> {
    @Override
    public T save(T entity) {
        return getDao().save(entity);
    }

    @Override
    public void deleted(ID id) {
        getDao().deleteById(id);
    }

    @Override
    public T get(ID id) {
        Optional<T> obj = getDao().findById(id);
        return obj.orElse(null);
    }

    @Override
    public List<T> getAll() {
        List<T> retunrList = new ArrayList<>();
        getDao().findAll().forEach(retunrList::add);
        return retunrList;
    }

    public abstract CrudRepository<T, ID> getDao();


}
