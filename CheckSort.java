����   8 F  unit7pre/CheckSort  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this Lunit7pre/CheckSort; main ([Ljava/lang/String;)V	    java/lang/System   out Ljava/io/PrintStream;  Enter list:
    java/io/PrintStream   print (Ljava/lang/String;)V  java/util/Scanner	  ! " # in Ljava/io/InputStream;
  %  & (Ljava/io/InputStream;)V
  ( ) * nextInt ()I
  , - . isSort ([I)Z 0 The list is already sorted
  2 3  println 5 The list is not sorted args [Ljava/lang/String; input Ljava/util/Scanner; sum I num [I i StackMapTable 7 = list check 
SourceFile CheckSort.java !               /     *� �    
                    	       �     N� � � Y�  � $L+� '=�
N6� -+� 'O����-� +� � /� 1� � 4� 1�    
   2      	  
     "  *  3  :  B  E  M     4    N 6 7    ; 8 9   6 : ;   2 < =    > ;  ?    � "  @  A  
�  	 - .     �     +<=� *.*`.� <� �*�d���� ��    
   & 	              "  '   ) "         + B =    ) C ;    > ;  ?    � �   D    E