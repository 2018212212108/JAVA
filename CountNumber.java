����   8 Z  unit7pre/CountNumber  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this Lunit7pre/CountNumber; main ([Ljava/lang/String;)V	    java/lang/System   out Ljava/io/PrintStream;  %Enter the integers between 1 and 100:
    java/io/PrintStream   print (Ljava/lang/String;)V  java/util/Scanner	  ! " # in Ljava/io/InputStream;
  %  & (Ljava/io/InputStream;)V
  ( ) * nextInt ()I , java/lang/StringBuilder
 . 0 / java/lang/String 1 2 valueOf (I)Ljava/lang/String;
 + 4   6  occurs 
 + 8 9 : append -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 + < 9 = (I)Ljava/lang/StringBuilder; ?  time
 + A B C toString ()Ljava/lang/String;
  E F  println H  times
  J K L hasNextLine ()Z args [Ljava/lang/String; input Ljava/util/Scanner; a [I b i I StackMapTable R 
SourceFile CountNumber.java !               /     *� �    
                    	      �     �� � � Y�  � $L� �d�
Md�
N6,+� 'O,.� � -,.\.`O����6� e-.� ,� � +Y� -� 35� 7-.� ;>� 7� @� D� 1-.� )� � +Y� -� 35� 7-.� ;G� 7� @� D�d���+� I��^�    
   N      	  
        #  +  2  5  ?  E  K  S  y  �  �  � 
 �     >    � M N    � O P   � Q R    � S R  # " T U  H l T U  V     	�  �  W W� � 0-�   X    Y