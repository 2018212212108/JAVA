����   8 L  unit7/Calculator  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this Lunit7/Calculator; main ([Ljava/lang/String;)V	    java/lang/System   out Ljava/io/PrintStream;  0Usage:java Calculator operand1 operator operand2
    java/io/PrintStream   println (Ljava/lang/String;)V
     ! exit (I)V
 # % $ java/lang/String & ' charAt (I)C
 ) + * java/lang/Integer , - parseInt (Ljava/lang/String;)I / java/lang/StringBuilder
 # 1 2 3 valueOf &(Ljava/lang/Object;)Ljava/lang/String;
 . 5   7  
 . 9 : ; append -(Ljava/lang/String;)Ljava/lang/StringBuilder; =  = 
 . ? : @ (I)Ljava/lang/StringBuilder;
 . B C D toString ()Ljava/lang/String; args [Ljava/lang/String; result I StackMapTable 
SourceFile Calculator.java !               /     *� �    
                    	      L     �*�� � � � <*2� "�   b   +   /   !   b   2   C   T*2� (*2� (`<� 3*2� (*2� (d<� "*2� (*2� (h<� *2� (*2� (l<� � .Y*2� 0� 46� 8*2� 86� 8*2� 8<� 8� >� A� �    
   Z        	     <  B  H  J  M  S  Y  [  ^  d  j  l  o  u  {  }   � "        � E F    � G H  I    � )  J    K