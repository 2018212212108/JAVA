����   8 Z  unit7pre/PrintDifferentNum  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this Lunit7pre/PrintDifferentNum; main ([Ljava/lang/String;)V	    java/lang/System   out Ljava/io/PrintStream;  Enter ten numbers:
    java/io/PrintStream   print (Ljava/lang/String;)V  java/util/Scanner	  ! " # in Ljava/io/InputStream;
  %  & (Ljava/io/InputStream;)V
  ( ) * nextInt ()I , java/lang/StringBuilder . !The number of distinct number is 
 + 0  
 + 2 3 4 append (I)Ljava/lang/StringBuilder;
 + 6 7 8 toString ()Ljava/lang/String;
  : ;  println = The distinct numbers are:
 ? A @ java/lang/String B C valueOf (I)Ljava/lang/String; E  
 + G 3 H -(Ljava/lang/String;)Ljava/lang/StringBuilder; args [Ljava/lang/String; num [I check I k input Ljava/util/Scanner; i a j StackMapTable J L 
SourceFile PrintDifferentNum.java !               /     *� �    
                    	      �     �
�
L=>� � � Y�  � $:6� 8� '66� +.� =� ����� +O�=�
��ǲ � +Y-� /� 1� 5� 9� <� 6� "� � +Y+.� >� /D� F� 5� ���ޱ    
   Z       	 	  
   #  *  0  9  ;  >  G  K  P  S  U  _  u  }  �  �  � $    \ 	   � I J    � K L   � M N  	 � O N   � P Q    ? R N  * + S N  -  T N  � ( R N  U   % 	� #  V W   � � � *  X    Y