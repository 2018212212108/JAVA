����   8 C  unit7pre/PartitionList  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this Lunit7pre/PartitionList; main ([Ljava/lang/String;)V
     Switch ([I)V	    java/lang/System   out Ljava/io/PrintStream;  java/lang/StringBuilder
    java/lang/String   ! valueOf (I)Ljava/lang/String;
  #  $ (Ljava/lang/String;)V &  
  ( ) * append -(Ljava/lang/String;)Ljava/lang/StringBuilder;
  , - . toString ()Ljava/lang/String;
 0 2 1 java/io/PrintStream 3 $ print args [Ljava/lang/String; list [I x I StackMapTable 5 7 i j flag temp 
SourceFile PartitionList.java !               /     *� �    
                    	       �     d�
Y
OYOYOYOY=OY	OYOYOL+� +Y:�6>� $.=� � Y� � "%� '� +� /���ܱ    
        ,  0  A 	 Z  c          d 4 5   , 8 6 7  A  8 9  :    � <  ; <  <    	       �     T<*�d=*.>� 9��*.� ���� �*.� ���� *.6**.O*O���**.O*O�    
   B                  #  /  4  9  ?  D  I % O & S '    4    T 6 7    R = 9   M > 9   I ? 9  9  @ 9  :    �   A    B