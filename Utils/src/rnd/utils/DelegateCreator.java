package com.csc.pt.svc;

import java.lang.reflect.Method;
import java.sql.Statement;

public class DelegateCreator {

	public static void main(String[] args) {

		Class cls = Statement.class;

		Method[] methods = cls.getMethods();
		
		System.out.println("private "+cls.getSimpleName() + " delegate;" );
		
		System.out.println("public PT"+cls.getSimpleName() + "(" + cls.getSimpleName()+ " delegate) {" );
		System.out.println("\tthis.delegate = delegate; \n }");
		
		for (Method method : methods) {

			Class[] parameterTypes = method.getParameterTypes();

			System.out.print("\npublic " + method.getReturnType().getSimpleName() + " " + method.getName() + "(");

			if (parameterTypes.length > 0) {
				System.out.print(parameterTypes[0].getSimpleName() + " arg0");

				for (int i = 1; i < parameterTypes.length; i++) {
					System.out.print(" , " + parameterTypes[i].getSimpleName() + " arg" + i);
				}
			}

			System.out.println(") { ");

			if (method.getReturnType() != void.class) {
				System.out.print("\treturn ");
			}

			System.out.print("delegate." + method.getName() + "(");

			if (parameterTypes.length > 0) {
				System.out.print("arg0");

				for (int i = 1; i < parameterTypes.length; i++) {
					System.out.print(" , " + " arg" + i);
				}

			}

			System.out.println(");");
			System.out.println(" }");

		}
	}
}
