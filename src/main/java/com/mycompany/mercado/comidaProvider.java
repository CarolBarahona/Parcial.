/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mercado;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Precondition;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.cloud.firestore.v1.FirestoreClient;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author barah
 */
public class comidaProvider {
     private static TableModel dataModel;
     
    static Firestore db = ConexionFirebase.db;
    
    public static boolean guardarcomidaprovider (String coleccion, String documento,
            Map<String, Object> data){
    
        try{
            DocumentReference docRef = db .collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.set(data);
            System.out.println(result.toString());
            System.out.println("Guardado correctamente");
            return true;
        }catch (Exception e){
            System.out.println("Error:"+e.getMessage());
        
        }
        return false;
    }
    
    public static boolean actualizarcomidaprovider (String coleccion, String documento,
            Map<String, Object> data){
    
        try{
            DocumentReference docRef = db .collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.update(data);
            System.out.println(result.toString());
            System.out.println("Actualizado correctamente");
            return true;
        }catch (Exception e){
            System.out.println("Error:"+e.getMessage());
        
        }
        return false;
    }
    
    public static boolean Eliminarcomidaprovider (String coleccion, String documento){
    
        try{
            DocumentReference docRef = db .collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.delete(Precondition.NONE);
            System.out.println(result.toString());
            System.out.println("Eliminado correctamente");
            return true;
        }catch (Exception e){
            System.out.println("Error:"+e.getMessage());
        
        }
        return false;
    }
    
    public static void cargarTabalacomidaprovider(JTable table){
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Tipo");
        model.addColumn("Nombre");
        
        try {
            CollectionReference comidas = ConexionFirebase.db.collection("Comida");
            ApiFuture<QuerySnapshot>  querySnap = comidas.get();
            for (QueryDocumentSnapshot document: querySnap.get().getDocuments()){
                model.addRow(new Object[]{
                  document.getString("Tipo"),
                  document.getString("Nombre"),  
                });
            }
        }catch (InterruptedException | ExecutionException e) {
        }
        table.setModel(dataModel);
    }

    public static void cargarTabalacomida(JTable tblcomida) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void eliminarcomidaprovider(String comida, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}