����   8 Z  unit9/TestPassObject  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this Lunit9/TestPassObject; main ([Ljava/lang/String;)V  !unit9/CircleWithPrivateDataFields
     (D)V
     
printAreas '(Lunit9/CircleWithPrivateDataFields;I)V	    java/lang/System   out Ljava/io/PrintStream;   java/lang/StringBuilder " 
Radius is 
  $  % (Ljava/lang/String;)V
  ' ( ) 	getRadius ()D
  + , - append (D)Ljava/lang/StringBuilder;
  / 0 1 toString ()Ljava/lang/String;
 3 5 4 java/io/PrintStream 6 % println 8 n is 
  : , ; (I)Ljava/lang/StringBuilder; args [Ljava/lang/String; myCircle #Lunit9/CircleWithPrivateDataFields; n I C Radius 		Area
 E G F java/lang/String H I valueOf (D)Ljava/lang/String; K 		
  M , N -(Ljava/lang/String;)Ljava/lang/StringBuilder;
  P Q ) getArea
  S T  	setRadius c times StackMapTable 
SourceFile TestPassObject.java !               /     *� �    
                    	       �     @� Y� L=+� � � Y!� #+� &� *� .� 2� � Y7� #� 9� .� 2�    
        	   	   )  ?          @ < =   	 7 > ?   5 @ A  	       �     A� B� 2� 3� � Y*� &� D� #J� L*� O� *� .� 2**� &c� R����α    
            .  8  ;  @         A U ?     A V A  W    /  X    Y