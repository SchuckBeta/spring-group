package com.example;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class AnnotationApply{
	public static void main(String[] args) {
		System.out.println("===自定义注解测试====================================================================================================================================");
		printClassAnno(10, Person.class, DBDesc.class, "DBDesc");
		printMethodAnno(11, Person.class, DBDesc.class, "DBDesc");
		printFieldAnno(12, Person.class, DBDesc.class, "DBDesc");
		
		printClassAnno(20, Worker.class, DBDesc.class, "DBDesc");
		printMethodAnno(21, Worker.class, DBDesc.class, "DBDesc");
		printFieldAnno(22, Worker.class, DBDesc.class, "DBDesc");
		
		printClassAnno(23, Worker.class, DBTable.class, "DBTable");
		printMethodAnno(24, Worker.class, DBTable.class, "DBTable");
		printFieldAnno(25, Worker.class, DBTable.class, "DBTable");
		
		printClassAnno(26, Worker.class, DBColumn.class, "DBColumn");
		printMethodAnno(27, Worker.class, DBColumn.class, "DBColumn");
		printFieldAnno(28, Worker.class, DBColumn.class, "DBColumn");
		System.out.println("================================================================================================================================================");
	}


	/**
	 * 打印类注解
	 * @param idx
	 * @param clazz
	 * @param annClazz
	 */
	private static void printClassAnno(Integer idx, Class<?> clazz, Class<? extends Annotation> annClazz, String type) {
		Object anno = getClassAnnotation(clazz, annClazz);
		System.out.println(idx+">>>---Object anno = getClassAnnotation("+clazz.getSimpleName()+".class, "+annClazz.getSimpleName()+".class)");
		if(anno == null){
			System.out.println(clazz.getSimpleName()+"类上面没有使用"+annClazz.getSimpleName()+"注解，所以打印不出来");
		}else{
			if(type.equals("DBDesc")){
				System.out.println(((DBDesc) anno).title()+"-"+((DBDesc) anno).remark());
			}else if(type.equals("DBTable")){
				System.out.println(((DBTable) anno).value());
			}else if(type.equals("DBColumn")){
				System.out.println(((DBColumn) anno).value());
			}
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------\n");
	}

	/**
	 * 打印方法注解
	 * @param idx
	 * @param clazz
	 * @param annClazz
	 */
	private static void printMethodAnno(Integer idx, Class<?> clazz, Class<? extends Annotation> annClazz, String type) {
		Map<Method, Annotation> annWMMap = getMethodsAnnotation(clazz.getMethods(), annClazz);
		System.out.println(idx+">>>---Map<Method, Annotation> annWMMap = getMethodsAnnotation("+clazz.getSimpleName()+".class.getMethods(), "+annClazz.getSimpleName()+".class)-"+annWMMap.size());
		if((annWMMap != null) && ((annWMMap.size() > 0))){
			Iterator<Entry<Method, Annotation>> itPM = annWMMap.entrySet().iterator();
			while(itPM.hasNext()){
				Entry<Method, Annotation> ety = itPM.next();
				Object anno = ety.getValue();
				if(type.equals("DBDesc")){
					System.out.println(ety.getKey().getName()+"="+((DBDesc) anno).title()+"-"+((DBDesc) anno).remark());
				}else if(type.equals("DBTable")){
					System.out.println(((DBTable) anno).value());
				}else if(type.equals("DBColumn")){
					System.out.println(((DBColumn) anno).value());
				}
			}
		}else{
			System.out.println(clazz.getSimpleName()+"的方法上面没有使用"+annClazz.getSimpleName()+"注解，所以打印不出来");
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------\n");
	}
	
	/**
	 * 打印属性注解
	 * @param idx
	 * @param clazz
	 * @param annClazz
	 */
	private static void printFieldAnno(Integer idx, Class<?> clazz, Class<? extends Annotation> annClazz, String type) {
		Map<Field, Annotation> annWFMap = getFieldsAnnotation(clazz.getFields(), annClazz);
		System.out.println(idx+">>>---Map<Field, Annotation> annWFMap = getFieldsAnnotation("+clazz.getSimpleName()+".class.getFields(), "+annClazz.getSimpleName()+".class)-"+annWFMap.size());
		if((annWFMap != null) && ((annWFMap.size() > 0))){
			Iterator<Entry<Field, Annotation>> itPF = annWFMap.entrySet().iterator();
			while(itPF.hasNext()){
				Entry<Field, Annotation> ety = itPF.next();
				Object anno = ety.getValue();
				if(type.equals("DBDesc")){
					System.out.println(ety.getKey().getName()+"="+((DBDesc) anno).title()+"-"+((DBDesc) anno).remark());
				}else if(type.equals("DBTable")){
					System.out.println(((DBTable) anno).value());
				}else if(type.equals("DBColumn")){
					System.out.println(((DBColumn) anno).value());
				}
			}
		}else{
			System.out.println(clazz.getSimpleName()+"的属性上面没有使用"+annClazz.getSimpleName()+"注解，所以打印不出来");
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------\n");
	}

	/******************************************************************************************************************************************************************************/
	
	/******************************************************************************************************************************************************************************
	 * 根据包获取类
	 * @param clazzPackage
	 * @return
	 */
	public static Class<?> loaderClass(String clazzPackage) {
		try {
			ClassLoader clazzLoader = Class.class.getClassLoader();
			return clazzLoader.loadClass(clazzPackage);
        } catch (SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		return null;
	}
	
	/**
	 * 根据包获取方法
	 * @param clazzPackage
	 * @return
	 */
	public static Method[] getMethods(String clazzPackage) {
		return loaderClass(clazzPackage).getMethods();
	}
	
	/**
	 * 根据包获取属性
	 * @param clazzPackage
	 * @return
	 */
	public static Field[] getFields(String clazzPackage) {
		return loaderClass(clazzPackage).getFields();
	}

	/**
	 * 获取指定类指定注解
	 * @param clazz
	 * @param annClazz
	 * @return
	 */
	public static Annotation getClassAnnotation(Class<?> clazz, Class<? extends Annotation> annClazz) {
        if (clazz.isAnnotationPresent(annClazz)) {
        	return clazz.getAnnotation(annClazz);
        }
		return null;
	}
	
	/**
	 * 获取指定方法指定注解
	 * @param clazzPackage
	 * @param annClazz
	 * @return
	 */
	public static Annotation getMethodAnnotation(Method method, Class<? extends Annotation> annClazz) {
        if (method.isAnnotationPresent(annClazz)) {
        	return method.getAnnotation(annClazz);
        }
		return null;
	}
	
	/**
	 * 获取所有方法指定注解
	 * @param clazzPackage
	 * @param annClazz
	 * @return
	 */
	public static Map<Method, Annotation> getMethodsAnnotation(Method[] methods, Class<? extends Annotation> annClazz) {
		Map<Method, Annotation> annMap = new HashMap<Method, Annotation>();
        for (Method m : methods) {
        	if (m.isAnnotationPresent(annClazz)) {
        		annMap.put(m, m.getAnnotation(annClazz));
        	}
        }
        return annMap;
	}
	
	/**
	 * 获取所有方法所有注解
	 * @param clazzPackage
	 * @param annClazz
	 * @return
	 */
	public static Map<Method, Annotation[]> getMethodsAnnotations(Method[] methods, Class<? extends Annotation> annClazz) {
		Map<Method, Annotation[]> annMap = new HashMap<Method, Annotation[]>();
        for (Method m : methods) {
        	annMap.put(m, m.getAnnotations());
        }
        return annMap;
	}

	/**
	 * 获取指定属性指定注解
	 * @param clazzPackage
	 * @param annClazz
	 * @return
	 */
	public static Annotation getFieldAnnotation(Field field, Class<? extends Annotation> annClazz) {
        if (field.isAnnotationPresent(annClazz)) {
        	return field.getAnnotation(annClazz);
        }
		return null;
	}
	
	/**
	 * 获取所有属性指定注解
	 * @param clazzPackage
	 * @param annClazz
	 * @return
	 */
	public static Map<Field, Annotation> getFieldsAnnotation(Field[] fields, Class<? extends Annotation> annClazz) {
		Map<Field, Annotation> annMap = new HashMap<Field, Annotation>();
        for (Field f : fields) {
        	if (f.isAnnotationPresent(annClazz)) {
        		annMap.put(f, f.getAnnotation(annClazz));
        	}
        }
        return annMap;
	}
	
	/**
	 * 获取所有属性所有注解
	 * @param clazzPackage
	 * @param annClazz
	 * @return
	 */
	public static Map<Field, Annotation[]> getFieldsAnnotations(Field[] fields, Class<? extends Annotation> annClazz) {
		Map<Field, Annotation[]> annMap = new HashMap<Field, Annotation[]>();
		for (Field f : fields) {
    		annMap.put(f, f.getAnnotations());
        }
        return annMap;
	}
}