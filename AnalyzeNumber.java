����   8 \  unit7/AnalyzeNumber  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this Lunit7/AnalyzeNumber; main ([Ljava/lang/String;)V  java/util/Scanner	    java/lang/System   in Ljava/io/InputStream;
     (Ljava/io/InputStream;)V	     out Ljava/io/PrintStream;   Enter the number of items: 
 " $ # java/io/PrintStream % & print (Ljava/lang/String;)V
  ( ) * nextInt ()I , Enter the numbers: 
  . / 0 
nextDouble ()D 2 java/lang/StringBuilder 4 Average is 
 1 6  &
 1 8 9 : append (D)Ljava/lang/StringBuilder;
 1 < = > toString ()Ljava/lang/String;
 " @ A & println C (Number of elements above the average is 
 1 E 9 F (I)Ljava/lang/StringBuilder;
  H I  close args [Ljava/lang/String; input Ljava/util/Scanner; n I numbers [D sum D i average count StackMapTable K Q 
SourceFile AnalyzeNumber.java !               /     *� �    
                    	      �  
   �� Y� � L� � !+� '=�N9� +� !6� -+� -R-1c9�����o966	� -	1�� ��		���� � 1Y3� 5� 7� ;� ?� � 1YB� 5� D� ;� ?+� G�    
   N          	  
   '  -  5  >  G  N  Q  W  d  m  �  �  �     \ 	   � J K    � L M   � N O   � P Q   � R S  *  T O  N R U S  Q O V O  T  T O 	 W   - � -  X  Y  �   X  Y    Z    [