/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.cput.hospitalapp.services;

import java.util.List;

/**
 *
 * @author Mhumhu
 */
public interface Services<S, ID> {
    public S find(ID id);

    public S persist(S entity);

    public S merge(S entity);

    public void remove(S entity);

    public List<S> findAll();
    
}
